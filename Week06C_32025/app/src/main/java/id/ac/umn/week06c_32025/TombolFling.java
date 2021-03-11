package id.ac.umn.week06c_32025;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;

public class TombolFling extends AppCompatButton {
    public TombolFling(@NonNull Context context) {
        super(context);
    }

    public TombolFling(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TombolFling(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent (MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            FlingAnimation fling = new FlingAnimation(
                    this, DynamicAnimation.ROTATION_X)
                    .setStartVelocity(150).setFriction(0.11f);
            fling.start();
        }
        return super.onTouchEvent(event);
    }
}
