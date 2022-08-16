package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

public class MarkCommand extends Command {
    int idx;

    public MarkCommand(int idx) {
        super();
        this.idx = idx;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (this.idx < 0 || this.idx >= tasks.getSize()) {
            throw new DukeException("The index provided is not within the list.");
        }
        ui.showMark(tasks.markTask(this.idx));
        storage.save(tasks.saveTasks());
    }
}