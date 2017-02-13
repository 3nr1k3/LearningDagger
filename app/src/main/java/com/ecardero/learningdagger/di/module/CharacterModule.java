package com.ecardero.learningdagger.di.module;

import com.ecardero.learningdagger.mvp.common.model.database.CharacterEntity;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ecardero on 8/02/17.
 */
@Module
public class CharacterModule {

    @Provides
    List<CharacterEntity> provideCharacters(){

        List<CharacterEntity> characters = new ArrayList<>();

        CharacterEntity char1 = new CharacterEntity.Builder()
                .setId(1009368)
                .setName("Iron Man")
                .setDescription("Un tipo con una armadura super molonga.")
                .setThumbnail("http://vignette4.wikia.nocookie.net/ironman/images/6/62/Mark43.PNG/revision/latest/scale-to-width-down/300?cb=20150603032716")
                .build();

        CharacterEntity char2 = new CharacterEntity.Builder()
                .setId(1009664)
                .setName("Thor")
                .setDescription("El dios del trueno?")
                .build();

        CharacterEntity char3 = new CharacterEntity.Builder()
                .setId(1009220)
                .setName("Captain Murica")
                .setDescription("Un soldado flipado.")
                .build();

        characters.add(char1);
        characters.add(char2);
        characters.add(char3);

        return characters;
    }
}
