package ru.gruzoff.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gruzoff.entity.User;

/**
 * The type Like dto.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {
    /**
     * The User from.
     */
    protected UserDto user_from;
    /**
     * The User to.
     */
    protected UserDto user_to;
}
