package com.ecardero.learningdagger.presentation.mvp.main.contract;

import com.ecardero.learningdagger.presentation.mvp.common.contract.BaseContract;
import com.ecardero.learningdagger.data.entity.database.CharacterEntity;

import java.util.List;

/**
 * Created by ecardero on 3/02/17.
 */

public interface MainActivityContract {

    interface Presenter<V extends View> extends BaseContract.Presenter<V>{
        void searchCharactersByName(String name);
    }

    interface View extends BaseContract.View{
        void updateCharactersList(List<CharacterEntity> characterList);

        void showMessage(String message);
    }
}
