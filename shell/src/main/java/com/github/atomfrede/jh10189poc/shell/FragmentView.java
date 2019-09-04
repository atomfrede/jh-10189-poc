package com.github.atomfrede.jh10189poc.shell;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

@Controller
public class FragmentView {

    @View("fragment")
    @Get
    public HttpResponse fragment() {

        return HttpResponse.ok();
    }
}
