package ir.aligorji.fluentvalidation;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseRule<T> implements Rule
{

    private final List<RuleValidator<T>> ruleValidators;
    private String value;

    private String display;
    private boolean stopOnFirstFailure;

    private final Context context;

    private String errors = null;
    private boolean isValid = true;

    public BaseRule(Context context)
    {
        this.context = context;
        this.ruleValidators = new ArrayList<>();
    }

    protected Context getContext()
    {
        return context;
    }
    protected String getDisplay()
    {
        return display;
    }

    public String getErrors()
    {
        return errors;
    }

    public boolean isValid()
    {
        return isValid;
    }

    private void addError(String error)
    {
        errors = (errors == null) ? error : errors + "\n" + error;
        isValid = false;
    }

    public void reset()
    {
        errors = null;
        isValid = true;
    }

    public String getValue()
    {
        return value;
    }

    @Override
    public void setValue(String value)
    {
        this.value = value;
    }

    @Override
    public void setDisplay(String display)
    {
        this.display = display;
    }

    public void stopOnFirstFailure(boolean stopOnFirstFailure)
    {
        this.stopOnFirstFailure = stopOnFirstFailure;
    }


    protected void add(RuleValidator<T> validator)
    {
        ruleValidators.add(validator);
    }

    //===================================


    public void validate()
    {
        reset();


        for (RuleValidator<T> rv : ruleValidators)
        {
            try
            {
                if (stopOnFirstFailure && !isValid)
                {
                    return;
                }

                rv.validate(context, (T) getParsedValue(value), display);
            }
            catch (ValidationException ex)
            {
                if (ex.isOverrideMessage())
                {
                    errors = ex.getMessage();
                }
                else
                {
                    addError(ex.getMessage());
                }
            }
        }


    }


}
