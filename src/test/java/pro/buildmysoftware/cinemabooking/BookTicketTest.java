package pro.buildmysoftware.cinemabooking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BookTicketTest {

	// @formatter:off
	@DisplayName(
		"can book a ticket in cinema"
	)
	//@formatter:on
	@Test
	// TODO: the initial idea might produce too big aggreagate, stick to
	//  the rules (see javadocs in Cinema)
	void bookTicket() throws Exception {
		// given
		var cinema = emptyCinema();
		var firstSeat = seat();
		var secondSeat = seat();
		var row = row();

		// when
		var event = cinema.book(row, firstSeat, secondSeat);

		// then
		assertThat(event).isNotNull();
	}

	private RowId row() {
		return null;
	}

	private SeatId seat() {
		return null;
	}

	private Cinema emptyCinema() {
		return null;
	}
}
