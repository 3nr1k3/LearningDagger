package com.ecardero.learningdagger.presentation.mvp.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ecardero.learningdagger.R;
import com.ecardero.learningdagger.data.entity.service.StarWarsApi.Character;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder>{

    private final CharacterAdapterCallback mClickCallback;

    Picasso mPicasso;
    private Context mContext;

    private List<Character> mCharacters = new ArrayList<>();

    @Inject
    public CharacterAdapter(
            @Named("ActivityContext") Context context,
            Picasso picasso
    ){
        mContext = context;
        mPicasso = picasso;
        mClickCallback = (CharacterAdapterCallback) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View viewRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);

        return new ViewHolder(viewRow);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(mCharacters.get(position).getAvatar() != null )
            mPicasso.load(mCharacters.get(position).getAvatar().getUrl()).centerCrop().fit().into(holder.mAvatar);

        holder.mName.setText(mCharacters.get(position).getName());
        holder.mSide.setText(mCharacters.get(position).getSide());

        holder.itemView.setOnClickListener(v -> mClickCallback.onClickCharacter(mCharacters.get(position)));
    }

    @Override
    public int getItemCount() {
        return mCharacters.size();
    }

    public void updateCharacters(List<Character> characters){
        this.mCharacters = characters;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_itemcharacter_thumb)  ImageView mAvatar;
        @BindView(R.id.tv_itemcharacter_name)   TextView mName;
        @BindView(R.id.tv_itemcharacter_side)   TextView mSide;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
