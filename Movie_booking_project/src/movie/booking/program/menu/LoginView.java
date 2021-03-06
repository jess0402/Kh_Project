package movie.booking.program.menu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import movie.booking.program.controller.FileUtil;
import movie.booking.program.controller.LoginManager;
import movie.booking.program.vo.Member;

public class LoginView {
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";   

	
	Scanner sc = new Scanner(System.in);
	
	private LoginManager lm = new LoginManager();
	
	String filePath = "/C:/Users/jes/Desktop/UserInfo/";
	String fileName = "membersInfo.txt";
	
	List<Member> loginCheck = new ArrayList<>();
	Member deleteCheck = new Member();
	File file = new File(filePath, fileName);
			
    String mainString = "\n=========๐ฅ Login Menu ๐ฅ===========\n"
    				  + "\t   1. ๋ก๊ทธ์ธ\n"
    				  + "\t   2. ๊ณ์  ๋ฑ๋ก\n"
    				  + "\t   3. ๊ณ์  ์ญ์ \n"
    				  + "\t   4. ๋ฑ๋ก๋ ๊ณ์  ์กฐํ\n"
    				  + "\t   9. ์ข๋ฃ\n"
    				  + "====================================\n"
    				  + "\tโ ๋ฉ๋ด ์ ํ : ";
    
	public int mainMenu() {
		while(true) {
			System.out.print(mainString);
			String choice = sc.next();
			
			outer:
			switch(choice) {
			//login
			case "1" :
				System.out.println("\n----------------๋ก๊ทธ์ธ---------------");
                System.out.print("\tโ ์์ด๋ : ");
                String inputId = sc.next();
                System.out.print("\tโ ๋น๋ฐ๋ฒํธ : ");
                String inputPw = sc.next();
				
                try {
                    loginCheck = FileUtil.readFile(file); 
                    for(int i = 0; i < loginCheck.size(); i++) {
                        if(inputId.equals(loginCheck.get(i).getId()) &&
                                inputPw.equals(loginCheck.get(i).getPassword())){
                            System.out.println("\t๐ถ ๋ก๊ทธ์ธ ์ฑ๊ณต ๐ถ");
                            return loginCheck.get(i).getMemberNo();
                        }
                    }
                    System.err.println("\tโ์์ด๋, ๋น๋ฐ๋ฒํธ๋ฅผ ์ฒดํฌํ์ธ์โ");
                    return -1;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


			//add
			case "2" :
				System.out.println("\n--------------ํ์ ๋ฑ๋ก---------------");
				lm.addMember(inputInfo());
				try {
					FileUtil.writeFile(filePath, fileName, lm.getMembers());
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
				
			//remove
			case "3" :
				System.out.println("\n--------------ํ์ ์ญ์ ---------------");
				System.out.print(" โ ์ญ์ ํ  ์์ด๋๋ฅผ ์๋ ฅํด์ฃผ์ธ์: ");
				String deleteId = sc.next();
				System.out.print(" โ ๋น๋ฐ๋ฒํธ๋ฅผ ์๋ ฅํด์ฃผ์ธ์: ");
				String deletepwd = sc.next();
				
				try {
					for(int i = 0; i < lm.getMembers().size(); i++) {
						if(FileUtil.readFile(new File(filePath, fileName)).get(i).getId().equals(deleteId)
							&& FileUtil.readFile(new File(filePath, fileName)).get(i).getPassword().equals(deletepwd)) {
							int deleteNo = FileUtil.readFile(new File(filePath, fileName)).get(i).getMemberNo();
							lm.removeMember(deleteNo);
							System.out.println("\n์ญ์ ๊ฐ ์๋ฃ๋์์ต๋๋ค.");
							break outer;
						}
						else { // ์์ ์๋ ๊ฒฝ์ฐ
							System.err.println("\n  โ์กด์ฌํ์ง ์๋ ํ์์๋๋ค.โ");
						}
					}
					System.err.println("\n  โ์กด์ฌํ์ง ์๋ ํ์์๋๋ค.โ");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
				
	            //๋ฑ๋ก๋ ๊ณ์  ์กฐํ
            case "4" :
                System.out.println("\n---------- ๋ฑ๋ก๋ ํ์ ์กฐํ ----------");
                System.out.print("โ ์์ด๋๋ฅผ ์๋ ฅํด์ฃผ์ธ์ : ");
                String searchId = sc.next();
                int cnt = 0;
                try {
                    loginCheck = FileUtil.readFile(new File(filePath, fileName));
                    if(loginCheck.isEmpty()) {
                        System.err.println("โ ๋ฑ๋ก๋์ง ์์ ํ์์๋๋ค โ");
                        System.out.println("-----------------------------------");
                    } else{
                        for(int i = 0; i < loginCheck.size(); i++) {
                            if(searchId.equals(loginCheck.get(i).getId())){
                                System.out.println(searchId + "๋์ ๋ฑ๋ก๋ ํ์์๋๋ค.");
                                System.out.println("-----------------------------------");
                                cnt++;
                                break;
                            }
                        }
                        if(cnt==0) {
                        	System.err.println("โ ๋ฑ๋ก๋์ง ์์ ํ์์๋๋ค โ");      
                        	System.out.println("-----------------------------------");
                        }
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
				
			case "9" : return 0;
			default : System.err.println("    โ๏ธ์ ํ์ง์ ์๋ ๋ฒํธ๋ง ์๋ ฅํด์ฃผ์ธ์โ๏ธ\n"); continue;
				
			}
		}
	} 
	
    public Member inputInfo() {
        Member m = new Member();
        System.out.print("\tโ ์ด๋ฆ : ");
        m.setName(sc.next());
        id:
        while(true) {
            System.out.print("\tโ ์์ด๋ : ");
            String checkId = sc.next();
            try {
                loginCheck = FileUtil.readFile(new File(filePath, fileName));
                if(loginCheck.isEmpty()) {
                    m.setId(checkId);
                    break id;
                }
                else{
                    for(int i = 0; i < loginCheck.size(); i++) {
                        if(checkId.equals(loginCheck.get(i).getId())){
                            System.err.println("\t" + checkId + "๋ ์ด๋ฏธ ๋ฑ๋ก๋ ์์ด๋์๋๋ค.");
                            System.err.println("\t๋ค๋ฅธ ์์ด๋๋ฅผ ์๋ ฅํด์ฃผ์ธ์.");
                            continue id;
                        } else {
                            m.setId(checkId);
                            break id;
                        }
                    }
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        System.out.print("\tโ ๋น๋ฐ๋ฒํธ : ");
        m.setPassword(sc.next());
        
        System.out.println("\n    ๐ํ์๋ฑ๋ก์ด ์๋ฃ๋์์ต๋๋ค!๐");
        
        return m;
        
    }

		
	

}