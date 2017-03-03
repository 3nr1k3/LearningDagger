package com.ecardero.learningdagger.presentation.Layout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ecardero.learningdagger.R;
import com.ecardero.learningdagger.data.entity.User;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class AvatarView extends FrameLayout {

    @BindView(R.id.iv_avatarview_avatar) ImageView icon;
    @BindView(R.id.tv_avatarview_initials) TextView initials;

    @Inject Picasso picasso;
    /**
     *
     * @param context
     * @param attrs
     */
    public AvatarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ButterKnife.bind(context, this);

        LayoutInflater.from(context).inflate(R.layout.view_avatar, this, true);
    }

    public void bind(User user){

        if(user.getAvatarResource() != 0 )
            icon.setImageResource(user.getAvatarResource());
        else if(    user.getAvatarUrl() != null
                && !user.getAvatarUrl().isEmpty())
            picasso.load(user.getAvatarUrl()).centerCrop().fit().into(icon);
        else{
            icon.setBackgroundColor(getResources().getColor(R.color.common_google_signin_btn_text_dark_focused));
            initials.setText(user.getInitials());
        }
    }
}
