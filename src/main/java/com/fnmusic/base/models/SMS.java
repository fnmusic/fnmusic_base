package com.fnmusic.base.models;

import java.io.Serializable;

public class SMS implements Serializable {

    private static final long serialVersionUID = 1L;

    private String[] to;
    private String from;
    private String message;
}
