package me.whiteship.natural.event;

import lombok.Getter;
import me.whiteship.natural.user.User;
import me.whiteship.natural.user.UserAdapter;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
public class EventResource extends EntityModel<Event> {

    public EventResource(Event event, Link... links) {
        super(event, links);
        add(linkTo(EventController.class).withRel("event"));
        add(linkTo(methodOn(EventController.class).getEvent(event.getId(), null)).withSelfRel());
    }

}
