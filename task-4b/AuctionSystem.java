import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Bidder {
    void update(String message);
    String getName();
}

// Concrete Observer
class ConcreteBidder implements Bidder {
    private String name;

    public ConcreteBidder(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }

    @Override
    public String getName() {
        return name;
    }
}

// Subject interface
interface Auction {
    void registerBidder(Bidder bidder);
    void removeBidder(Bidder bidder);
    void notifyBidders(String message);
}

// Concrete Subject
class AuctionEvent implements Auction {
    private List<Bidder> bidders;
    private String auctionItem;

    public AuctionEvent(String auctionItem) {
        this.auctionItem = auctionItem;
        this.bidders = new ArrayList<>();
    }

    @Override
    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
        System.out.println(bidder.getName() + " has subscribed to the auction for " + auctionItem);
    }

    @Override
    public void removeBidder(Bidder bidder) {
        bidders.remove(bidder);
        System.out.println(bidder.getName() + " has unsubscribed from the auction for " + auctionItem);
    }

    @Override
    public void notifyBidders(String message) {
        for (Bidder bidder : bidders) {
            bidder.update(message);
        }
    }

    public void startBidding() {
        System.out.println("Bidding started for " + auctionItem);
        notifyBidders("Bidding started for " + auctionItem);
    }

    public void endBidding() {
        System.out.println("Bidding ended for " + auctionItem);
        notifyBidders("Bidding ended for " + auctionItem);
    }

    public void newItemAvailable() {
        System.out.println("New item available: " + auctionItem);
        notifyBidders("New item available: " + auctionItem);
    }
}

// Main class
public class AuctionSystem {
    public static void main(String[] args) {
        // Create an auction event
        AuctionEvent auction = new AuctionEvent("Antique Vase");

        // Create bidders
        Bidder bidder1 = new ConcreteBidder("Alice");
        Bidder bidder2 = new ConcreteBidder("Bob");
        Bidder bidder3 = new ConcreteBidder("Charlie");

        // Register bidders
        auction.registerBidder(bidder1);
        auction.registerBidder(bidder2);

        // Auction events
        auction.newItemAvailable();
        auction.startBidding();

        // Bob unsubscribes from the auction
        auction.removeBidder(bidder2);

        auction.endBidding();

        // Charlie subscribes after bidding started
        auction.registerBidder(bidder3);

        // Notify bidders about another event
        auction.newItemAvailable();
    }
}