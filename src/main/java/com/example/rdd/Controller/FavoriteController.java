package com.example.rdd.Controller;

import com.example.rdd.Controller.Generic.GenericController;
import com.example.rdd.Domain.Favorite.Favorite;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorite")
public class FavoriteController extends GenericController<Favorite, Long> {
}
