package com.jiyun.qcloud.newkuangjia.api;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jiyun.qcloud.newkuangjia.mvp.model.Card;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by chj on 2017/8/30.
 */
public class CardsDeserializer implements JsonDeserializer<List<Card>>{
    @Override
    public List<Card> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Type listType=new TypeToken<List<Card>>(){}.getType();
        List<Card> cards=null;
        try{
            cards=new Gson().fromJson(json,listType);

        }catch (JsonSyntaxException e){
            System.out.println(e);
        }
        return cards;
    }
}
