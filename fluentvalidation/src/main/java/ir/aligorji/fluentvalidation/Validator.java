package ir.aligorji.fluentvalidation;


import android.databinding.Bindable;
import android.support.annotation.StringRes;


public abstract class Validator<T> extends Command
{

    private String error;
    private String display;
    private boolean isValid;
    protected boolean isAlive = true;
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

    public boolean isAlive()
    {
        return isAlive;
    }
    public Validator<T> alive()
    {
        return alive(true);
    }

    public Validator<T> alive(boolean v)
    {
        isAlive = v;
        return this;
    }

    public Validator<T> stopOnFirstFailure()
    {
        return stopOnFirstFailure(true);
    }

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


        if (isAlive())
        {
            isValid(true);
        }

        if (commandValidator.isFink())
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

    @Bindable
    public Integer getIValue()
    {
        try
        {
            return getDValue().intValue();
        }
        catch (Throwable ignored)
        {

        }
        return null;
    }

    @Bindable
    public Double getDValue()
    {
        try
        {
            return Double.parseDouble(getParsedValue().toString());
        }
        catch (Throwable ignored)
        {

        }
        return null;
    }

    @Bindable
    public Boolean getBValue()
    {
        Double o = getDValue();

        return o != null && o != 0;
    }


}
