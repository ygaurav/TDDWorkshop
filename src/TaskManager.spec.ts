
import { TaskManager} from '../TaskManager'
import { expect } from 'chai';
import 'mocha';

describe('Hello function', () => {

  it('check for task create', () => {
    var taskManager = new TaskManager();
    expect(taskManager.AddTask('hello')).to.equal(2);
  });

  it('check for task create', () => {
    var taskManager = new TaskManager();
    expect(taskManager.AddTask('Hi')).to.equal(2);
  });

  it('check for task fetching ID', () => {
    var taskManager = new TaskManager();
    expect(taskManager.GetTask(2));
  });
});
