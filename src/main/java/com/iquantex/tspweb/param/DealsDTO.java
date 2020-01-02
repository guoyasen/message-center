package com.iquantex.tspweb.param;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class DealsDTO {
    private List<Deal> deals;
}
