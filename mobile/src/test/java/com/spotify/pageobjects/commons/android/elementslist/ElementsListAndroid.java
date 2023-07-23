package com.spotify.pageobjects.commons.android.elementslist;

import com.spotify.pageobjects.base.AppiumPageAndroid;
import com.spotify.pageobjects.commons.interfaces.elementslist.ElementsList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Slf4j
public class ElementsListAndroid extends AppiumPageAndroid implements ElementsList {

    //ToDo: move getting elements from the list methods here
}
