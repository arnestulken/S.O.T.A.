package de.aska.game.event;

import de.aska.game.model.Game;
import de.aska.network.Session;

import java.awt.*;

/**
 * Created ExecuteConditionEvent in event.event
 * by ARSTULKE on 20.01.2017.
 */
public class ExecuteConditionEvent extends Event {
    private final String conditionName;
    private final String expectedConditionValue;
    private final Event event;

    public ExecuteConditionEvent(Rectangle triggerArea, boolean repeatable, String conditionName, String expectedConditionValue, Event event) {
        super(triggerArea, repeatable);
        this.conditionName = conditionName;
        this.expectedConditionValue = expectedConditionValue;
        this.event = event;
    }

    @Override
    public void execute(Session session, Game game) {
        String conditionValue = game.getCondition(conditionName);
        if(conditionValue != null && this.expectedConditionValue.equals(conditionValue)) {
            this.event.execute(session, game);
        }
    }
}
