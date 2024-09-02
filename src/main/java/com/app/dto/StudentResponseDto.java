package com.app.dto;


public record StudentResponseDto( //when we save record of student it will return
                                  String firstname,
                                  String lastname,
                                  String email
) {
}

