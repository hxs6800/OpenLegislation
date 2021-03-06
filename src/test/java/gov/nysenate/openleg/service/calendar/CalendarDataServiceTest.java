package gov.nysenate.openleg.service.calendar;

import gov.nysenate.openleg.BaseTests;
import gov.nysenate.openleg.dao.base.LimitOffset;
import gov.nysenate.openleg.dao.base.SortOrder;
import gov.nysenate.openleg.service.calendar.data.CalendarDataService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CalendarDataServiceTest extends BaseTests
{
    private static final Logger logger = LoggerFactory.getLogger(CalendarDataServiceTest.class);
    @Autowired
    private CalendarDataService calendarDataService;

    @Test
    public void getCalendarsByYearTest() {
        logger.info("Calendar Ids for 2014:");
        calendarDataService.getCalendars(2014, SortOrder.DESC, LimitOffset.ALL)
                .forEach(calId -> logger.info(calId.toString()));
    }
}
