package movie.booking.program.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

import movie.booking.program.vo.Member;
import movie.booking.program.vo.Movie;

/**
 * 	Menu에서 선택 시 처리과정
 *
 */
public class MovieManager {
	private Scanner sc = new Scanner(System.in);
	
	Map<String, Movie> map = new HashMap<>();
    List<Member> nowId = new ArrayList<>();
    List<Movie> tempMovie = new ArrayList<>();
    
	private String str = "";
	
	private List<Movie> yongSan = new ArrayList<>();
	private List<Movie> hongDae = new ArrayList<>();
	private List<Movie> gangNam = new ArrayList<>();
	
	List<Movie> temp = new ArrayList<>();
	List<String> selectSeat = new ArrayList<>();
	List<Movie> completeMovieList = new ArrayList<>(); 
    int movieIndex = 0;
    int seatIndex = 0;
    
    String filePath = "/C:/Users/jes/Desktop/UserInfo/";
    String fileName = "membersInfo.txt";
	
	public MovieManager() {
		yongSan.add(new Movie("더 배트맨", "용산점", 13, 15, "10:35"));
		yongSan.add(new Movie("나이트메어 앨리", "용산점", 2, 15, "13:55"));
		yongSan.add(new Movie("나이트 레이더스", "용산점", 17, 15, "12:15"));
		
		hongDae.add(new Movie("더 배트맨", "홍대점", 4, 15, "11:45"));
		hongDae.add(new Movie("나이트메어 앨리", "홍대점", 6, 15, "11:55"));
		hongDae.add(new Movie("안터벨룸", "홍대점", 3, 15, "21:50"));
		
		gangNam.add(new Movie("더 배트맨", "강남점", 1, 15, "14:50"));
		gangNam.add(new Movie("나이트메어 앨리", "강남점", 6, 15, "21:10"));
		gangNam.add(new Movie("안터벨룸", "강남점", 1, 15, "21:40"));
		
	}

	public MovieManager(List<Movie> yongSan, List<Movie> hongDae, List<Movie> gangNam) {
		this.yongSan = yongSan;
		this.hongDae = hongDae;
		this.gangNam = gangNam;
	}
	
	/**
	 * main 1. 극장별 현재 상영 영화 스케쥴 출력
	 */
	public void printSchedule(String choiceTheater) {
			int j;
			
			switch(choiceTheater) {
			case "1" : 
				j = 1;
				for(int i = 0; i < yongSan.size(); i++) {
					System.out.println(j++ + ". " +yongSan.get(i));
				}
				break;
			case "2" : 
				j = 1;
				for(int i = 0; i < hongDae.size(); i++) {
					System.out.println(j++ + ". " +hongDae.get(i));
				}
				break;
			case "3" :
				j = 1;
				for(int i = 0; i < gangNam.size(); i++) {
					System.out.println(j++ + ". " +gangNam.get(i));
				}
				break;
			case "0" : return;
			default : System.err.println("잘못 입력하셨습니다. 메인메뉴로 돌아갑니다.");
			}
	}

	/**
	 * main menu 2. 영화별 예매하기
	 */
	public Movie bookingByMovie(String choiceMovie) {
		outer:
		while(true) {
			int j;
			switch(choiceMovie) {

			case "1" :
				System.out.println("\n============== 📽 영화 선택 ===============\n\n");
				j = 1;
				for(int i = 0; i < yongSan.size(); i++) {
					if(yongSan.get(i).getMovieName().equals("더 배트맨")) {
						System.out.println(j++ + ". " + yongSan.get(i));
						temp.add(yongSan.get(i));
					}
					if(hongDae.get(i).getMovieName().equals("더 배트맨")) {
						System.out.println(j++ + ". " + hongDae.get(i));
						temp.add(hongDae.get(i));
					}
					if(gangNam.get(i).getMovieName().equals("더 배트맨")) {
						System.out.println(j++ + ". " + gangNam.get(i));
						temp.add(gangNam.get(i));
					}
				}

				break outer;

			case "2" :
				System.out.println("\n============== 📽 극장 선택 ===============\n\n");
				j = 1;
				for(int i = 0; i< yongSan.size(); i++) {
					if(yongSan.get(i).getMovieName().equals("나이트메어 앨리")) {
						System.out.println(j++ + ". " + yongSan.get(i));
						temp.add(yongSan.get(i));
					}
					if(hongDae.get(i).getMovieName().equals("나이트메어 앨리")) {
						System.out.println(j++ + ". " + hongDae.get(i));
						temp.add(hongDae.get(i));
					}
					if(gangNam.get(i).getMovieName().equals("나이트메어 앨리")) {
						System.out.println(j++ + ". " + gangNam.get(i));
						temp.add(gangNam.get(i));

					}
				}
				break outer;

			case "3" :
				System.out.println("\n============== 📽 극장 선택 ===============\n\n");
				j = 1;
				for(int i = 0; i< yongSan.size(); i++) {
					if(yongSan.get(i).getMovieName().equals("나이트 레이더스")) {
						System.out.println(j++ + ". " + yongSan.get(i));
						temp.add(yongSan.get(i));
					}
					if(hongDae.get(i).getMovieName().equals("나이트 레이더스")) {
						System.out.println(j++ + ". " + hongDae.get(i));
						temp.add(hongDae.get(i));
					}
					if(gangNam.get(i).getMovieName().equals("나이트 레이더스")) {
						System.out.println(j++ + ". " + gangNam.get(i));
						temp.add(gangNam.get(i));

					}
				}
				break outer;

			case "4" :
				System.out.println("\n============== 📽 극장 선택 ===============\n\n");
				j = 1;
				for(int i = 0; i< yongSan.size(); i++) {
					if(yongSan.get(i).getMovieName().equals("안터벨룸")) {
						System.out.println(j++ + ". " + yongSan.get(i));
						temp.add(yongSan.get(i));
					}
					if(hongDae.get(i).getMovieName().equals("안터벨룸")) {
						System.out.println(j++ + ". " + hongDae.get(i));
						temp.add(hongDae.get(i));
					}
					if(gangNam.get(i).getMovieName().equals("안터벨룸")) {
						System.out.println(j++ + ". " + gangNam.get(i));
						temp.add(gangNam.get(i));
					}
				}
				break outer;

			case "0" : return null;
			default:
				System.err.println("잘못 입력하셨습니다. 메인메뉴로 돌아갑니다.");
				return null;
			}
		}
		afterMovieChoice();			
		return completeMovieList.get(movieIndex++);
	}
	
	// 2. 영화 선택 후 극장 선택 
	public void afterMovieChoice() {
		
		String lastTheaterChoice;
		 
		while(true) {
		try {
			System.out.print("➜ 극장 선택 : ");
			lastTheaterChoice = sc.next();			
			if(Integer.parseInt(lastTheaterChoice) > 0 && Integer.parseInt(lastTheaterChoice) <= temp.size())
				break;
			else
				System.err.println("선택지에 있는 값을 입력해주세요.");
		} catch(NumberFormatException e) {
			System.err.println("숫자만 입력해주세요.");
			continue;
		}
	}
		
		switch(lastTheaterChoice) {
		case "1" :
			completeMovieList.add(temp.get(0));
			System.out.println(completeMovieList.get(movieIndex));
			temp.clear();
			break;
		case "2" :
			completeMovieList.add(temp.get(1));
			System.out.println(completeMovieList.get(movieIndex));
			temp.clear();
			break;
		case "3" :
			completeMovieList.add(temp.get(2));
			System.out.println(completeMovieList.get(movieIndex));
			temp.clear();
			break;
		}	

	}
	
	/**
	 *  main menu 3. 극장별 예매하기
	 */
	public Movie bookingByTheater(String choiceTheater) {
		outer:
		while(true) {
			int j;
			switch(choiceTheater) {
			//용산
			case "1" : 
				System.out.println("\n============== 📽 영화 선택 ===============\n\n");
				j = 1;
				for(int i = 0; i < yongSan.size(); i++) {
					System.out.println(j++ + ". " +yongSan.get(i));
					temp.add(yongSan.get(i));
				}
				break outer;

				//홍대
			case "2" : 
				System.out.println("\n============== 📽 영화 선택 ===============\n\n");
				j = 1;
				for(int i = 0; i < hongDae.size(); i++) {
					System.out.println(j++ + ". " +hongDae.get(i));
					temp.add(hongDae.get(i));
				}
				break outer;

				//강남
			case "3" :
				System.out.println("\n============== 📽 영화 선택 ===============\n\n");
				j = 1;
				for(int i = 0; i < gangNam.size(); i++) {
					System.out.println(j++ + ". " +gangNam.get(i));
					temp.add(gangNam.get(i));
				}
				break outer;
			case "0" : return null;
			default : System.err.println("잘못 입력하셨습니다. 메인메뉴로 돌아갑니다."); return null;
			}
		}
		
			
		afterTheaterChoice();
		return completeMovieList.get(movieIndex++);

	}
	
	//3. 극장선택 후 영화 선택 
	public void afterTheaterChoice() {
		
		String lastMovieChoice;
		
		while(true) {
			try {
				System.out.print("➜ 영화 선택 : ");
				lastMovieChoice = sc.next();
				
				if(Integer.parseInt(lastMovieChoice) > 0 && Integer.parseInt(lastMovieChoice) <= temp.size())
					break;
				else
					System.err.println("선택지에 있는 값을 입력해주세요.");
			} catch(NumberFormatException e) {
				System.err.println("숫자만 입력해주세요.");
				continue;
			}
		}
		
		switch(lastMovieChoice) {
		case "1" :
			completeMovieList.add(temp.get(0));
			System.out.println(completeMovieList.get(movieIndex));
			temp.clear();
			break;
		case "2" :
			completeMovieList.add(temp.get(1));
			System.out.println(completeMovieList.get(movieIndex));
			temp.clear();
			break;
		case "3" :
			completeMovieList.add(temp.get(2));
			System.out.println(completeMovieList.get(movieIndex));
			temp.clear();
			break;
		}
	
	}
	
	// main 2, 3번 출력용
	public void nowBookingPrint(int memberNo) {
		String name = "";
		String pastList = "";
		BufferedReader br = null;
		
		// 기존 파일 있는지 확인
		try {
			nowId = FileUtil.readFile(new File(filePath, fileName));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		for(int i = 0; i < nowId.size(); i++) {
			if(nowId.get(i).getMemberNo() == memberNo) {
				name = ("C:/Users/jes/Desktop/MovieInfo/" + nowId.get(i).getId() + "_movieList.txt");
				break;
			}
		}
		
		File inFile = new File(name);
		
		try {
			br = new BufferedReader(new FileReader(inFile));
			String data = null;
			while((data = br.readLine()) != null) {
				pastList += (data + "\n");
			} 
			JOptionPane.showMessageDialog(null, pastList, "현재 예매 내역", JOptionPane.INFORMATION_MESSAGE);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
			
	}

	public void takenSeat(String selectedSeat) {
		selectSeat.add(selectedSeat);
		seatIndex++;
	}

	/**
	 * 예매 취소
	 */
	public void deleteBooking(int realIndex) {
		selectSeat.remove(realIndex);
		seatIndex--;
		completeMovieList.remove(realIndex);
		movieIndex--;
	}
	
	/**
	 * main 4. 나의 예매내역
	 */
//	public boolean myBooking(String choiceMyBooking) {
//		outer:
//		while(true) {
//			switch(choiceMyBooking) {
//			case "1":
//				if(completeMovieList.isEmpty()) {
//					JOptionPane.showMessageDialog(null, "예매 내역이 없습니다.",
//												  "예매 내역 확인",
//							                      JOptionPane.WARNING_MESSAGE);
//					break outer;
//				}
//				else{
//					nowBookingPrint();
//				}
//				return true;
//			case "2":
//				if(completeMovieList.isEmpty()) {					
//					JOptionPane.showMessageDialog(null, "예매 내역이 없습니다.",
//												  "예매 내역 확인",
//												  JOptionPane.WARNING_MESSAGE);
//					break outer;
//				}
//				else{
//					nowBookingPrint();
//					//삭제할 내역을 선택하세요
//					System.out.println("--------------------");					
//					int choiceRemove = 0;
//					String tempchoiceRemove;
//					
//					while(true) {
//						try {
//							System.out.print(">> 삭제할 내역을 선택하세요 : ");
//							tempchoiceRemove = sc.next();
//							
//							if(Integer.parseInt(tempchoiceRemove) > 0 &&
//									Integer.parseInt(tempchoiceRemove) <= completeMovieList.size()) {
//								choiceRemove = Integer.parseInt(tempchoiceRemove);
//								break;
//							}
//							else
//								System.err.println("선택지에 있는 값을 입력해주세요.");
//						} catch(NumberFormatException e) {
//							System.err.println("숫자만 입력해주세요.");
//							continue;
//						}
//					}
//
//					//삭제진행
//					Movie deleteMovie = completeMovieList.get(choiceRemove-1);
//                    char rowSeat = selectSeat.get(choiceRemove-1).charAt(0);
//                    int colSeat = Character.getNumericValue(selectSeat.get(choiceRemove-1).charAt(1));
//                    deleteMovie.getSeats()[rowSeat - 65][colSeat - 1] = "︎☐ ";
//					completeMovieList.remove(choiceRemove - 1);
//					selectSeat.remove(choiceRemove-1);
//					movieIndex--;
//					System.out.println(choiceRemove + "번 취소가 완료되었습니다!");
//					
//				}
//				return false;
//			case "0": return true;
//			default : System.err.println("잘못 입력하셨습니다. 메인메뉴로 돌아갑니다."); return true;
//			}
//		}
//		return true;
//	}
	
	
	public void movieFile(int memberNo) {
		BufferedReader br = null;
		BufferedWriter bw = null;	

		String name = "";
		String pastList = "";
		
		// 기존 파일 있는지 확인
		try {
			nowId = FileUtil.readFile(new File(filePath, fileName));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		for(int i = 0; i < nowId.size(); i++) {
			if(nowId.get(i).getMemberNo() == memberNo) {
				name = ("C:/Users/jes/Desktop/MovieInfo/" + nowId.get(i).getId() + "_movieList.txt");
				break;
			}
		}
		
		File f = new File(name);
		
		if(f.exists()) {
			try {
				File inFile = new File(name);
				br = new BufferedReader(new FileReader(inFile));
				String data = null;
				while((data = br.readLine()) != null) {
					pastList += (data + "\n");
				}
				
				File outFile = new File(name);
				bw = new BufferedWriter(new FileWriter(outFile));
				bw.write(pastList);
				
				String nowList = "";
				for(int i = 0; i < completeMovieList.size(); i++) {		
					String temp = (i+1 + ". " + completeMovieList.get(i) 
					+ "\n좌석: " + selectSeat.get(i) + "\n");
					
					if(nowList.contains(temp))
						continue;
					else
						nowList += temp;
				}
				
				bw.write(nowList);
				
			} catch (IOException e) {
		          e.printStackTrace();
			} finally {
				try {
					bw.close();
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			
			try {
				File outFile = new File(name);
				bw = new BufferedWriter(new FileWriter(outFile));
				bw.write(pastList);
				
				String nowList = "";
				for(int i = 0; i < completeMovieList.size(); i++) {		
					String temp = (i+1 + ". " + completeMovieList.get(i) 
					+ "\n좌석: " + selectSeat.get(i) + "\n");
					
					if(nowList.contains(temp))
						continue;
					else
						nowList += temp;
				}
				System.out.println(nowList);
				bw.write(nowList);
			} catch (IOException e) {
		          e.printStackTrace();
			} finally {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	/**
	 * main 4. 나의 예매내역
	 */
	public boolean myBooking(String choiceMyBooking, int memberNo) {
		BufferedReader br = null;
		BufferedWriter bw = null;	
		FileReader fr = null;
		FileWriter fw = null;
		
		int index = 0;
		String name = "";
		String pastList = "";
		
		// 예매 내역 불러오기
		try {
			nowId = FileUtil.readFile(new File(filePath, fileName));
		} catch (IOException e1) {
			e1.printStackTrace();
		} 

		for(int i = 0; i < nowId.size(); i++) {
			if(nowId.get(i).getMemberNo() == memberNo) {
				index = i;
				name = ("C:/Users/jes/Desktop/MovieInfo/" + nowId.get(i).getId() + "_movieList.txt");
				break;
			}
		}
		
		File f = new File(name);
		
		outer:
		while(true) {
			switch(choiceMyBooking) {
			case "1":
				if(f.exists()) {
					nowBookingPrint(memberNo);
				}
				else {
					JOptionPane.showMessageDialog(null, "예매 내역이 없습니다.",
					"예매 내역 확인", JOptionPane.WARNING_MESSAGE);
					break outer;
				}
				
				return true; 
				
			case "2":
				if(!(f.exists())) {					
					JOptionPane.showMessageDialog(null, "예매 내역이 없습니다.",
												  "예매 내역 확인",
												  JOptionPane.WARNING_MESSAGE);
					break outer;
				}
				
				else{
					
					nowBookingPrint(memberNo);
				
					//삭제할 내역을 선택하세요
					System.out.println("--------------------");					
					int choiceRemove = 0;
					String tempchoiceRemove;
					
					while(true) {
						try {
							System.out.print(">> 삭제할 내역을 선택하세요 : ");
							tempchoiceRemove = sc.next();
							
							
							if(Integer.parseInt(tempchoiceRemove) > 0 &&
									Integer.parseInt(tempchoiceRemove) <= completeMovieList.size()) {
								choiceRemove = Integer.parseInt(tempchoiceRemove);
								break;
							}
							else
								System.err.println("선택지에 있는 값을 입력해주세요.");
						} catch(NumberFormatException e) {
							System.err.println("숫자만 입력해주세요.");
							continue;
						}
					}

					//삭제진행
					Movie deleteMovie = completeMovieList.get(choiceRemove-1);
                    char rowSeat = selectSeat.get(choiceRemove-1).charAt(0);
                    int colSeat = Character.getNumericValue(selectSeat.get(choiceRemove-1).charAt(1));
                    deleteMovie.getSeats()[rowSeat - 65][colSeat - 1] = "︎☐ ";
					completeMovieList.remove(choiceRemove - 1);
					selectSeat.remove(choiceRemove-1);
					movieIndex--;
					System.out.println(choiceRemove + "번 취소가 완료되었습니다!");
					
				}
				return false;
			case "0": return true;
			default : System.err.println("잘못 입력하셨습니다. 메인메뉴로 돌아갑니다."); return true;
			}
		}
		return true;
	}
	

	
}