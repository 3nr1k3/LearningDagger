package com.ecardero.learningdagger.presentation.mvp.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ecardero.learningdagger.R;
import com.ecardero.learningdagger.data.entity.service.StarWarsApi.Character;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder>{

    @Inject Picasso picasso;
    @Inject @Named("AppContext") Context context;

    //private final Context mContext;
    private final CharacterAdapterCallback mListener;
    private List<Character> mCharacters = new ArrayList<>();

    public CharacterAdapter(CharacterAdapterCallback listener){
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View viewRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        ViewHolder viewRowHolder = new ViewHolder(viewRow);

        return viewRowHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        picasso.load(mCharacters.get(position).getImageUrl()).centerCrop().fit().into(holder.mAvatar);
    }

    @Override
    public int getItemCount() {
        return mCharacters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_itemcharacter_thumb) ImageView mAvatar;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
