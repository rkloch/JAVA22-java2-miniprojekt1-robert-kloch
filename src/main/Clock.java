package main;

import java.util.Scanner;

import date.ClockDate;
import time.ClockTime;

public class Clock implements ClockActions {
	STATE currentState = STATE.DisplayTime;
	ClockDate date = new ClockDate();
	ClockTime time = new ClockTime();

	enum STATE {
		DisplayTime {
			@Override
			public STATE setState() {
				return SetTime;
			}

			@Override
			public STATE changeMode() {
				return DisplayDate;
			}
		},
		DisplayDate {
			@Override
			public STATE setState() {
				return SetDate;
			}

			@Override
			public STATE changeMode() {
				return DisplayTime;
			}
		},
		SetDate {
			@Override
			public STATE changeMode() {
				return DisplayDate;
			}

			@Override
			public STATE setState() {
				// TODO Auto-generated method stub
				return null;
			}
		},
		SetTime {
			@Override
			public STATE changeMode() {
				return DisplayTime;
			}

			@Override
			public STATE setState() {
				// TODO Auto-generated method stub
				return null;
			}
		};

		public abstract STATE setState();

		public abstract STATE changeMode();
	}

	public static void main(String[] args) {
		Clock clock = new Clock();
		clock.mainLoop();

	}

	public void mainLoop() {
		while (true) {
			switch (currentState) {
			case DisplayTime:
				displayTime();
				userInput();
				break;
			case DisplayDate:
				displayDate();
				userInput();
				break;
			case SetDate:
				setDate();
				currentState = currentState.changeMode();
				break;
			case SetTime:
				setTime();
				currentState = currentState.changeMode();
				break;
			default:
				break;
			}
		}
	}

	private void userInput() {
		System.out.println("1. Set " + (currentState == STATE.DisplayTime ? "time" : "date"));
		System.out.println("2. Change mode to " + (currentState == STATE.DisplayTime ? "date" : "time"));
		Scanner scanner = new Scanner(System.in);

		String str = scanner.nextLine().trim();
		if (str.equals("1")) {
			currentState = currentState.setState();
		} else if (str.equals("2")) {
			currentState = currentState.changeMode();
		} else {
			System.out.println("wrong input");
		}

	}

	@Override
	public void displayTime() {
		time.displayTime();

	}

	@Override
	public void displayDate() {
		date.displayDate();

	}

	@Override
	public void setTime() {
		Scanner scanner = new Scanner(System.in);
		boolean isHoursCorrect = false;
		boolean isMinutesCorrect = false;
		boolean isSecondsCorrect = false;
		int hour = 0;
		int minutes = 0;
		int seconds = 0;
		while (!isHoursCorrect) {
			System.out.println("Hours: ");
			String userInput = scanner.nextLine().trim();

			try {
				Integer.parseInt(userInput);
				if (Integer.parseInt(userInput) > -1 && Integer.parseInt(userInput) < 24) {
					hour = Integer.parseInt(userInput);
					isHoursCorrect = true;
				}
			} catch (Exception e) {

			}
		}
		while (!isMinutesCorrect) {
			System.out.println("Minutes: ");
			String userInput = scanner.nextLine();
			try {
				Integer.parseInt(userInput);
				if (Integer.parseInt(userInput) > -1 && Integer.parseInt(userInput) < 60) {
					minutes = Integer.parseInt(userInput);
					isMinutesCorrect = true;
				}
			} catch (Exception e) {

			}
		}
		while (!isSecondsCorrect) {
			System.out.println("Seconds: ");
			String userInput = scanner.nextLine();
			try {
				Integer.parseInt(userInput);
				if (Integer.parseInt(userInput) > -1 && Integer.parseInt(userInput) < 60) {
					seconds = Integer.parseInt(userInput);
					isSecondsCorrect = true;
				}
			} catch (Exception e) {

			}
		}

		time.setTime(hour, minutes, seconds);

	}

	@Override
	public void setDate() {
		Scanner scanner = new Scanner(System.in);
		boolean isYearCorrect = false;
		boolean isMonthCorrect = false;
		boolean isDayCorrect = false;
		int year = 0;
		int month = 0;
		int day = 0;
		while (!isYearCorrect) {
			System.out.println("Year: ");
			String userInput = scanner.nextLine().trim();

			try {

				year = Integer.parseInt(userInput);
				isYearCorrect = true;

			} catch (Exception e) {

			}
		}
		while (!isMonthCorrect) {
			System.out.println("Month: ");
			String userInput = scanner.nextLine();
			try {
				Integer.parseInt(userInput);
				if (Integer.parseInt(userInput) > 0 && Integer.parseInt(userInput) < 13) {
					month = Integer.parseInt(userInput);
					isMonthCorrect = true;
				}
			} catch (Exception e) {

			}
		}
		while (!isDayCorrect) {
			System.out.println("Day: ");
			String userInput = scanner.nextLine();
			try {
				Integer.parseInt(userInput);
				if (Integer.parseInt(userInput) > 0 && Integer.parseInt(userInput) < 32) {
					day = Integer.parseInt(userInput);
					isDayCorrect = true;
				}
			} catch (Exception e) {

			}
		}

		date.setDate(year, month, day);

	}

}
