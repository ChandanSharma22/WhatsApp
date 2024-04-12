package com.ck.WhatsApp.Activities;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.ck.WhatsApp.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class SampleShowUserView extends LinearLayout {

    private CircleImageView profileImage;
    private ImageView lockIcon;
    private OnProfileImageClickListener onProfileImageClickListener;

    public SampleShowUserView(Context context) {
        super(context);
        init(context);
    }

    public SampleShowUserView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SampleShowUserView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.sample_show_user, this);
        profileImage = findViewById(R.id.profile_image);
        lockIcon = findViewById(R.id.lockIcon);

        // Set click listener on profile image
        profileImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onProfileImageClickListener != null) {
                    onProfileImageClickListener.onProfileImageClick();
                }
            }
        });
    }

    public void setOnProfileImageClickListener(OnProfileImageClickListener listener) {
        this.onProfileImageClickListener = listener;
    }

    public interface OnProfileImageClickListener {
        void onProfileImageClick();
    }

    public CircleImageView getProfileImage() {
        return profileImage;
    }

    public void showLockIcon() {
        lockIcon.setVisibility(View.VISIBLE);
    }

    public void hideLockIcon() {
        lockIcon.setVisibility(View.GONE);
    }
}
