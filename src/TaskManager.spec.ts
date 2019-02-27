import { TaskManager } from '../TaskManager'
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


  it('check for task count', () => {
    var taskManager = new TaskManager();
    expect(taskManager.GetTaskCount()).to.equals(0);
  });

  it("check for task delete", () => {
    var taskManager = new TaskManager();
    taskManager.AddTask('hello');
    taskManager.AddTask('hi');
    expect(taskManager.removeTask(1)).to.equals(1);
  });

});