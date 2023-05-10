package App;
import javax.swing.*;

// Local imports
import auth.Access;
import backend.json.JsonEdit;
import shopPage.Shop;
import Menu.Menu;
import slotMachine.SlotMachine;
import corsaCavalli.CorsaCavalli;
import blackJack.BlackJack;

public class VirtualCasino extends JFrame{
	private Access access = new Access(this);
	private Menu menu = new Menu(this);	
	private Shop shop = new Shop();
	private SlotMachine slotMachine = new SlotMachine(menu);
	private CorsaCavalli corsaCavalli = new CorsaCavalli();
	private BlackJack blackJack = new BlackJack();
	private String isSelected = "";
	String[] userData;
	
	public VirtualCasino() {
		super("Il Casino Virtuale");
		setSize(1300, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		init();

		setVisible(true);
	}
	
	public void init() {
		// Aggiunta del pannello di login
		this.getContentPane().add(access);

		// Aggiunta del pannello di menu
		menu = new Menu(this);
		menu.setVisible(false);
		this.getContentPane().add(menu);


		shop.setVisible(false);
		this.getContentPane().add(shop);

		slotMachine.setVisible(false);
		this.getContentPane().add(slotMachine);

		corsaCavalli.setVisible(false);
		this.getContentPane().add(corsaCavalli);

		blackJack.setVisible(false);
		this.getContentPane().add(blackJack);
	}

	public void login(){
		access.setVisible(false);
		menu.setVisible(true);
		shop.setVisible(false);
		slotMachine.setVisible(false);
		corsaCavalli.setVisible(false);
		blackJack.setVisible(false);
		
	}

	public void logout(){
		access.setVisible(true);
		menu.setVisible(false);
		shop.setVisible(false);
		slotMachine.setVisible(false);
		corsaCavalli.setVisible(false);
		blackJack.setVisible(false);
	}

	public void setShop() {
		isSelected = "shop";
		shop.setVisible(true);
		slotMachine.setVisible(false);
		corsaCavalli.setVisible(false);
		blackJack.setVisible(false);
		shop.saldo.setText("Saldo: "+ String.valueOf(JsonEdit.readSaldo(userData[0], userData[1])) + " FishCoin");
	}

	public void setSlotMachine() {
		isSelected = "slotMachine";
		shop.setVisible(false);
		slotMachine.setVisible(true);
		corsaCavalli.setVisible(false);
		blackJack.setVisible(false);
		slotMachine.saldo.setText("Saldo: "+ String.valueOf(JsonEdit.readSaldo(userData[0], userData[1])) + " FishCoin");
	}

	public void setCorsaCavalli() {
		isSelected = "corsaCavalli";
		shop.setVisible(false);
		slotMachine.setVisible(false);
		corsaCavalli.setVisible(true);
		blackJack.setVisible(false);
		corsaCavalli.saldo.setText("Saldo: "+ String.valueOf(JsonEdit.readSaldo(userData[0], userData[1])) + " FishCoin");
	}

	public void setBlackJack() {
		isSelected = "blackJack";
		shop.setVisible(false);
		slotMachine.setVisible(false);
		corsaCavalli.setVisible(false);
		blackJack.setVisible(true);
		blackJack.saldo.setText("Saldo: "+ String.valueOf(JsonEdit.readSaldo(userData[0], userData[1])) + " FishCoin");
	}

	public String getIsSelected() {
		return isSelected;
	}
	
	public void setEmail(String email) {
		menu.user.setText(JsonEdit.getUser(email));
		userData = menu.user.getText().split(" ");
		slotMachine.saldo.setText("Saldo: "+ String.valueOf(JsonEdit.readSaldo(userData[0], userData[1])) + " FishCoin");
		slotMachine.userData = userData;
		blackJack.saldo.setText("Saldo: "+ String.valueOf(JsonEdit.readSaldo(userData[0], userData[1])) + " FiashCoin");
		blackJack.userData = userData;
		corsaCavalli.saldo.setText("Saldo: "+ String.valueOf(JsonEdit.readSaldo(userData[0], userData[1])) + " FishCoin");
		corsaCavalli.userData = userData;
		shop.userData = userData;
		shop.saldo.setText("Saldo: "+ String.valueOf(JsonEdit.readSaldo(userData[0], userData[1])) + " FishCoin");
	}
	public static void main(String[] args) {
		new VirtualCasino();
	}
}