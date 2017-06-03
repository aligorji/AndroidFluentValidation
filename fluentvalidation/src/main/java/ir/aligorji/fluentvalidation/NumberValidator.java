package ir.aligorji.fluentvalidation;


import android.support.annotation.StringRes;


public final class NumberValidator<T extends Number> extends Validator<T>
{

    public NumberValidator(CommandValidator commandValidator, @StringRes int resDisplay)
    {
        super(commandValidator, resDisplay);
    }
    public NumberValidator(CommandValidator commandValidator, String display)
    {
        super(commandValidator, display);
    }


    @Override
    public Number getParsedValue()
    {
        try
        {
            return (Number) getRule().getParsedValue(getValue());
        }
        catch (ValidationNumberParseException e)
        {

        }
        return null;
    }

    @Override
    protected boolean isNumeric()
    {
        return true;
    }

    @Override
    public NumberRule<T> rule()
    {
        return (NumberRule<T>) super.rule();
    }

    @Override
    public NumberValidator<T> alive()
    {
        return (NumberValidator<T>) super.alive(true);
    }

    @Override
    public NumberValidator<T> alive(boolean v)
    {
        return (NumberValidator<T>) super.alive(true);
    }

    @Override
    public NumberValidator<T> stopOnFirstFailure(boolean v)
    {
        return (NumberValidator<T>) super.stopOnFirstFailure(v);
    }

    public NumberValidator<T> stopOnFirstFailure()
    {
        return (NumberValidator<T>) super.stopOnFirstFailure(true);
    }

}
