package app.parser;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelParser {

    private ModelMapper modelMapper;

    public ModelParser() {
        this.modelMapper = new ModelMapper();
    }

    public <S,D> D convert(S source, Class<D> destination){
        D convertedObject = this.modelMapper.map(source, destination);
        return convertedObject;
    }

    public <S,D> List<D> convert(List<S> source, Class<D> destination){
        List<D> convertedList = new ArrayList<D>();
        for (S s : source) {
            D convertedType = this.modelMapper.map(s, destination);
            convertedList.add(convertedType);
        }

        return convertedList;
    }

    public <S,D> List<D> convert(List<S> source, Class<D> destination, PropertyMap<S,D> propertyMap){
        this.modelMapper.addMappings(propertyMap);
        List<D> convertedList = new ArrayList<D>();
        for (S s : source) {
            D convertedType = this.modelMapper.map(s, destination);
            convertedList.add(convertedType);
        }

        return convertedList;
    }

    public <S,D> D convert(S source, Class<D> destination, PropertyMap<S,D> propertyMap){
        this.modelMapper.addMappings(propertyMap);
        D convertedObject = this.modelMapper.map(source, destination);
        return convertedObject;
    }
}
