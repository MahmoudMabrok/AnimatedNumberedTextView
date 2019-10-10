package views.mahmoudmabrok.animatedtextview;

import android.animation.ValueAnimator;
import android.content.Context;

import androidx.appcompat.widget.AppCompatTextView;

public class AnimatedNumberedTextView extends AppCompatTextView implements ValueAnimator.AnimatorUpdateListener {

    int currentValue = 0;
    private ValueAnimator animator;

    public AnimatedNumberedTextView(Context context) {
        super(context);
    }

    public void animateTo(int value) {
        animator = new ValueAnimator();
        animator.setTarget(this);
        animator.setIntValues(currentValue, value);
        animator.addUpdateListener(this);
        animator.start();
    }

    public void updateValue(int amount) {
        if (animator != null) {
            animator.cancel();
            animator = null;
        }
        animator = new ValueAnimator();
        animator.setTarget(this);
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
