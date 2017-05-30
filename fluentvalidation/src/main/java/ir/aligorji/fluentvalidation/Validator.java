package ir.aligorji.fluentvalidation;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.StringRes;


public abstract class Validator<T> extends BaseObservable
{

    private String error;
    private String display;
    private boolean isValid;
    protected boolean isValidateIfChangeValue;
    protected boolean isCommandValidateIfChangeValue;
    private String value;


    private final CommandValidator commandValidator;

    private Rule rule = null;

    public Validator(CommandValidator commandValidator, @StringRes int resDisplay)
    {
        this(commandValidator, commandValidator.getContext().getString(resDisplay));
    }

    public Validator(CommandValidator commandValidator, String display)
    {
        super();
        this.isValid = true;
        this.error = null;
        this.display = display;

        if (isNumeric())
        {
            rule = new NumberRule(commandValidator.getContext());
        }
        else
        {
            rule = new TextRule(commandValidator.getContext());
        }

        rule.setDisplay(display);

        this.commandValidator = commandValidator;
        this.commandValidator.add(this);
    }

    protected abstract boolean isNumeric();

    public Rule rule()
    {
        return rule;
    }

    public Rule getRule()
    {
        return rule;
    }


    //=========================

    public abstract Object getParsedValue();

    public void setParsedValue(T v)
    {
        setValue(String.valueOf(v));
    }

    public boolean isValidateIfChangeValue()
    {
        return isValidateIfChangeValue;
    }
    public boolean isCommandValidateIfChangeValue()
    {
        return isCommandValidateIfChangeValue;
    }
    public abstract Validator<T> validateIfChangeValue(boolean v);

    public abstract Validator<T> commandValidateIfChangeValue(boolean v);

    public Validator<T> stopOnFirstFailure(boolean v)
    {
        rule.stopOnFirstFailure(v);
        return this;
    }

    public boolean isValid(boolean uiAction)
    {
        getRule().validate();

        if (uiAction)
        {
            setIsValid(getRule().isValid());
            setError((getIsValid()) ? null : String.format(getRule().getErrors(), getDisplay()));
        }

        return getRule().isValid();
    }

    @Bindable
    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
        rule.setValue(value);

        notifyPropertyChanged(ir.aligorji.fluentvalidation.BR.value);


        if (isValidateIfChangeValue)
        {
            isValid(true);
        }

        if (isCommandValidateIfChangeValue)
        {
            commandValidator.isValid(false);
        }

    }

    @Bindable
    public String getError()
    {
        return error;
    }
    public void setError(String error)
    {
        this.error = error;
        notifyPropertyChanged(BR.error);
    }

    @Bindable
    public String getDisplay()
    {
        return display;
    }
    public void setDisplay(String display)
    {
        this.display = display;
        rule.setDisplay(display);

        notifyPropertyChanged(ir.aligorji.fluentvalidation.BR.display);
    }

    @Bindable
    public boolean getIsValid()
    {
        return isValid;
    }
    public void setIsValid(boolean isValid)
    {
        this.isValid = isValid;
        notifyPropertyChanged(ir.aligorji.fluentvalidation.BR.isValid);
    }

}
