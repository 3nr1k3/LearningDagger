package com.ecardero.learningdagger.presentation.mvp.main.adapter;


import com.ecardero.learningdagger.data.entity.service.StarWarsApi.Character;

public interface CharacterAdapterCallback {
    void onClickCharacter(Character item);
}
