package views.mahmoudmabrok.animatedtextview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;

import java.util.Locale;

import androidx.appcompat.widget.AppCompatTextView;

public class AnimatedNumberedTextView extends AppCompatTextView implements ValueAnimator.AnimatorUpdateListener {

    int currentValue = 0;
    private ValueAnimator animator;
    private String message = "";

    public AnimatedNumberedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTextColor(context.getResources().getColor(R.color.tvColor));
        setBackgroundResource(R.drawable.view_bg);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void animateTo(int value, int duration) {
        animator = new ValueAnimator();
        animator.setTarget(this);
        animator.setDuration(duration);
        animator.setIntValues(currentValue, value);
        animator.addUpdateListener(this);
        animator.start();
        currentValue = value;
    }

    public void updateValue(int amount, int duration) {
        if (animator != null) {
            animator.cancel();
            animator = null;
        }
        animator = new ValueAnimator();
        animator.setTarget(this);
        animator.setDuration(duration);
        animator.setIntValues(currentValue, currentValue + amount);
        animator.addUpdateListener(this);
        animator.start();
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        int value = (int) animation.getAnimatedValue();
        setText(String.format("%s %d", message, value, Locale.getDefault()));
    }

}
