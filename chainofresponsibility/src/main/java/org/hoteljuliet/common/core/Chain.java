package java.org.hoteljuliet.common.core;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 */
public class Chain {

    private List<Command> commands;

    /**
     *
     */
    public Chain() {
        commands = new ArrayList<>();
    }

    /**
     *
     * @param command
     */
    public void addCommand(Command command) {
        commands.add(command);
    }

    /**
     *
     * @param context
     * @return
     * @throws Exception
     */
    boolean execute(Context context) throws RuntimeException {

        boolean processingComplete = false;

        // in forward order, call the execute method
        for (Command command : commands) {
            processingComplete = command.execute(context);
            if (processingComplete) {
                break;
            }
            else {
                ;
            }
        }

        // in reverse order, call the post processing method
        ListIterator<Command> listIterator = commands.listIterator(commands.size());
        while(listIterator.hasPrevious()) {
            listIterator.previous().postProcess(context);
        }

        return processingComplete;
    }


}
