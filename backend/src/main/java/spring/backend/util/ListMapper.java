package spring.backend.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListMapper<T,E> {

    private final ModelMapper modelMapper;

    public ListMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public List<?> mapList(List<T> list, Class<E> convertTo){
        return
                list.stream()
                        .map(e-> modelMapper.map(e, convertTo))
                        .collect(Collectors.toList());
    }

}