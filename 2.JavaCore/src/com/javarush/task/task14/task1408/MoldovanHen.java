package com.javarush.task.task14.task1408;

class MoldovanHen extends Hen {

  @Override
  public int getCountOfEggsPerMonth() {
    return 3;
  }

  @Override
  String getDescription() {
    return String.format("%s Моя страна - %s. Я несу %d яиц в месяц.", super.getDescription(), Country.MOLDOVA,
        getCountOfEggsPerMonth());
  }

}
