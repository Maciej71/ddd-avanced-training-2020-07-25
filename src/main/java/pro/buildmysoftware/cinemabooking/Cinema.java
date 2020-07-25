package pro.buildmysoftware.cinemabooking;

import pro.buildmysoftware.common.domain.AggregateRoot;
import pro.buildmysoftware.common.domain.Version;

import java.util.List;

/**
 * Rule: there can be no empty spaces between booking in a row. Therefore,
 * the current aggregate might be too big, consider implementing this as
 * CinemaRow instead.
 */
// TODO: consider modeling aggregate as CinemaRow instead of entire Cinema to
//  avoid concurrent access and performance issues
public class Cinema implements AggregateRoot<CinemaId> {

	private List<Row> rows;
	private Version version;

	public BookingConfirmed book(RowId row, SeatId... seats) {

		return null;
	}

	@Override
	public CinemaId id() {
		return null;
	}

	@Override
	public Version version() {
		return null;
	}
}
