package ir.aligorji.fluentvalidation;


import android.content.Context;
import android.databinding.ObservableField;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandValidator
{

    private final List<CustomRuleValidator> customRuleValidators;
    private final Context context;
    private List<Validator> validators = new ArrayList<>();
    private String cError = null;
    private boolean stopOnFirstFailure = false;
    private boolean isFink = false;
    public final ObservableField<String> customErrors = new ObservableField<>();
    public final ObservableField<Boolean> isValid = new ObservableField<>();
    private OnChangeValidator mOnChangeValidatorListener = null;

    public CommandValidator(Context context)
    {
        this.context = context;
        customRuleValidators = new ArrayList<>();
    }

    public Context getContext()
    {
        return context;
    }


    public void add(Validator validator)
    {
        validators.add(validator);
    }

    private void addError(String error)
    {
        cError = (cError == null) ? error : cError + "\n" + error;
    }

    public boolean isStopOnFirstFailure()
    {
        return stopOnFirstFailure;
    }

    public void stopOnFirstFailure()
    {
        stopOnFirstFailure(true);
    }
    public void stopOnFirstFailure(boolean stopOnFirstFailure)
    {
        this.stopOnFirstFailure = stopOnFirstFailure;
    }

    public boolean isFink()
    {
        return isFink;
    }

    public void fink()
    {
        fink(true);
    }

    public void fink(boolean isFink)
    {
        this.isFink = isFink;
    }

    public boolean isValid(boolean uiAction)
    {

        boolean isValid = true;

        for (Validator validator : validators)
        {

            if (stopOnFirstFailure && !isValid)
            {
                break;
            }

            validator.getRule().validate();

            if (isValid && !validator.getRule().isValid())
            {
                isValid = false;
            }

            if (uiAction)
            {
                validator.setIsValid(validator.getRule().isValid());
                validator.setError((validator.getIsValid()) ? null : String.format(validator.getRule().getErrors(), validator.getDisplay()));
            }
        }

        cError = null;

        //custom validation
        for (CustomRuleValidator rv : customRuleValidators)
        {
            if (stopOnFirstFailure && !isValid)
            {
                break;
            }

            try
            {
                rv.validate(context);
            }
            catch (ValidationException ex)
            {
                isValid = false;

                if (ex.isOverrideMessage())
                {
                    cError = ex.getMessage();
                }
                else
                {
                    addError(ex.getMessage());
                }
            }


        }


        customErrors.set(cError);
        this.isValid.set(isValid);

        if (mOnChangeValidatorListener != null)
        {
            mOnChangeValidatorListener.onChangeValidation(isValid);
        }

        return isValid;
    }

    protected void custom(CustomRuleValidator validator)
    {
        customRuleValidators.add(validator);
    }

    public void setListener(OnChangeValidator listener)
    {
        mOnChangeValidatorListener = listener;
    }

    public OnChangeValidator getListener()
    {
        return mOnChangeValidatorListener;
    }

    //=========================

    public interface OnChangeValidator
    {

        void onChangeValidation(boolean isValid);
    }

}
