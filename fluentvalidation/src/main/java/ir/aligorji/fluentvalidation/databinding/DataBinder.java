package ir.aligorji.fluentvalidation.databinding;

import android.databinding.BindingAdapter;
import android.support.design.widget.TextInputLayout;

public final class DataBinder
{

    private DataBinder()
    {
        //NO-OP
    }

//    @BindingAdapter({"bind:imageUrl", "bind:error"})
//    public static void loadImage(ImageView imageView, String url, Drawable error)
//    {
//        Context context = imageView.getContext();
//
//        Glide.with(context).load(url).into(imageView);
//    }

    @BindingAdapter({"bind:error"})
    public static void inputValidation(TextInputLayout inputLayout, String error)
    {
        if (error == null || error.isEmpty())
        {
            inputLayout.setError(null);
            inputLayout.setErrorEnabled(false);
        }
        else
        {
            inputLayout.setError(error);
            inputLayout.setErrorEnabled(true);
        }

    }


}