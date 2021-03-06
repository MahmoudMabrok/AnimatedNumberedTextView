package views.mahmoudmabrok.animatedtextview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
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
        setGravity(Gravity.CENTER);
        String txSize = attrs.getAttributeValue(null,"textSize");
        setTextSize(Integer.parseInt(txSize));
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void animateTo(int value, int duration) {
        int start = currentValue;
        animator = new ValueAnimator();
        animator.setTarget(this);
        animator.setDuration(duration);
        animator.setIntValues(start, value);
        animator.addUpdateListener(this);
        animator.start();
        currentValue = value;
    }

    public void updateValue(int amount, int duration) {
        if (animator != null) {
            animator.cancel();
            animator = null;
        }
        int start = currentValue;
        animator = new ValueAnimator();
        animator.setTarget(this);
        animator.setDuration(duration);
        animator.setIntValues(start, start + amount);
        animator.addUpdateListener(this);
        animator.start();

        currentValue += amount;
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        int value = (int) animation.getAnimatedValue();
        setText(String.format( Locale.getDefault(),"%s %d", message, value));
    }

}
