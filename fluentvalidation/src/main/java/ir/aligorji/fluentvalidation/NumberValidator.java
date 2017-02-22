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
        catch (ValidationException e)
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
    public NumberValidator<T> validateIfChangeValue(boolean v)
    {
        isValidateIfChangeValue = v;
        return this;
    }

    @Override
    public NumberValidator<T> stopOnFirstFailure(boolean v)
    {
        super.stopOnFirstFailure(v);
        return this;
    }

}
