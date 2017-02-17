package com.ecardero.learningdagger.data.entity.mapper;

//region Copyright
/**           _MMMMM`
 *     __MMMMMMMMM`       J        openTrends Solucions i Sistemes, S.L.
 * JMMMMMMMMMMMMF       JM         http://www.opentrends.net
 * MMMMMMMMMMF       _JMM`         info@opentrends.net
 * MMMMMMMF`    .JMMMMF`
 * """")    _JMMMMMMF`
 * _MMMMMMMMMMMMMMM`      .M)      Barcelona, 08020
 * MMMMMMMMMMMMMF`     .JMM`       Spain
 * MMMMMMMMMM"     _MMMMMF
 * M4MMM""`   ._MMMMMMMM`          *************************************
 * _______MMMMMMMMMMMF             LearningDagger
 * MMMMMMMMMMMMMMMM"               *************************************
 * MMMMMMMMMMMMF"                  Copyright (C) 2017 ecardero, Tots els drets reservats
 * MMMMMMMM""                      Copyright (C) 2017 ecardero, All Rights Reserved
 *
 *                                 This program is free software; you can redistribute it and/or modify
 *                                 it under the terms of the GNU General Public License as published by
 *                                 the Free Software Foundation; either version 2 of the License, or
 *                                 (at your option) any later version.
 *
 *                                 This program is distributed in the hope that it will be useful,
 *                                 but WITHOUT ANY WARRANTY; without even the implied warranty of
 *                                 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *                                 GNU General Public License for more details.
 *
 *                                 You should have received a copy of the GNU General Public License along
 *                                 with this program; if not, write to the Free Software Foundation, Inc.,
 *                                 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
//endregion
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <O> Origin
 * @param <R> Result
 */
public abstract class Mapper<O, R> {

    public abstract R map(O value);
    public abstract O reverseMap(R value);

    public List<R> map(List<O> values){
        List<R> returnValues = new ArrayList<R>(values.size());
        for(O value : values){
            returnValues.add(map(value));
        }
        return returnValues;
    }

    public List<O> reverseMap(List<R> values){
        List<O> returnValues = new ArrayList<>(values.size());
        for(R value : values){
            returnValues.add(reverseMap(value));
        }
        return returnValues;
    }
}
