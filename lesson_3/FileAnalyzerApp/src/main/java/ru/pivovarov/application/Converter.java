package ru.pivovarov.application;

import com.beust.jcommander.Parameter;

import java.util.Arrays;
import java.util.List;

import com.beust.jcommander.converters.CommaParameterSplitter;
import com.beust.jcommander.converters.IParameterSplitter;


public class Converter  implements IParameterSplitter {

    @Parameter(  names = { "--paths"}, splitter = CommaParameterSplitter.class)
    private List<String> references;


    @Override
    public List split(String value) {
        return Arrays.asList(value.split(","));
    }

    public List<String> getReferences (){

        return references;
    }


}

