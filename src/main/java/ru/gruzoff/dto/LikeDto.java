package ru.gruzoff.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gruzoff.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {
    protected UserDto user_from;
    protected UserDto user_to;
}
