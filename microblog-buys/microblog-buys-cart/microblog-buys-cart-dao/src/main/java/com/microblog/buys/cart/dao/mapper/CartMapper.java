package com.microblog.buys.cart.dao.mapper;

import com.microblog.buys.cart.dao.model.Cart;
import java.util.List;

public interface CartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbggenerated
     */
    int insert(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbggenerated
     */
    Cart selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbggenerated
     */
    List<Cart> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Cart record);
}