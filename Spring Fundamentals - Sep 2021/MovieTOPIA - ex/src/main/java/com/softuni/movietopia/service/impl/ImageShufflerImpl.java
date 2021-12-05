package com.softuni.movietopia.service.impl;

import com.softuni.movietopia.service.ImageShuffler;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ImageShufflerImpl implements ImageShuffler {
  @Override
  public void shuffle(List<String> images) {
    Collections.shuffle(images);
  }
}
