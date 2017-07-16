package ir.aligorji.fluentvalidation;


import android.databinding.BaseObservable;
import android.databinding.Bindable;


public abstract class Command extends BaseObservable
{
    @Bindable
    public abstract Integer getIValue();

    @Bindable
    public abstract Double getDValue();

    @Bindable
    public abstract Boolean getBValue();

    @Bindable
    public abstract String getValue();
    public abstract void setValue(String value);

    @Bindable
    public abstract String getError();
    public abstract void setError(String error);

    @Bindable
    public abstract String getDisplay();
    public abstract void setDisplay(String display);

    @Bindable
    public abstract boolean getIsValid();
    public abstract void setIsValid(boolean isValid);

}
