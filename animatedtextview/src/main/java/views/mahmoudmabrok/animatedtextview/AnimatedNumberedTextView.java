package views.mahmoudmabrok.animatedtextview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class AnimatedNumberedTextView extends AppCompatTextView implements ValueAnimator.AnimatorUpdateListener {

    int currentValue = 0;
    private ValueAnimator animator;

    public AnimatedNumberedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
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
        setText(String.valueOf(value));
    }

}
