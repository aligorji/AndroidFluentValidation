package ir.aligorji.fluentvalidation;


import android.support.annotation.StringRes;


public final class TextValidator extends Validator<String>
{

    public TextValidator(CommandValidator commandValidator, @StringRes int resDisplay)
    {
        super(commandValidator, resDisplay);
    }
    public TextValidator(CommandValidator commandValidator, String display)
    {
        super(commandValidator, display);
    }


    public String getParsedValue()
    {
        return getValue();
    }

    @Override
    protected boolean isNumeric()
    {
        return false;
    }

    @Override
    public TextRule rule()
    {
        return (TextRule) super.rule();
    }


    @Override
    public TextValidator alive()
    {
        return (TextValidator) super.alive();
    }

    @Override
    public TextValidator alive(boolean v)
    {
        return (TextValidator) super.alive(v);
    }

    @Override
    public TextValidator stopOnFirstFailure(boolean v)
    {
        return (TextValidator) super.stopOnFirstFailure(v);
    }

    public TextValidator stopOnFirstFailure()
    {
        return (TextValidator) super.stopOnFirstFailure(true);
    }

}
