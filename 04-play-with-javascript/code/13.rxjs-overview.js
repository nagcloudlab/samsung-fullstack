

const Rx = require('rxjs'); // cjs
const {
    filter
} = require('rxjs/operators'); // cjs

// create an observable stream

// const teachStream = new Rx.Subject();
const teachStream = new Rx.BehaviorSubject('topic-0');
// const teachStream = new Rx.ReplaySubject(100); // buffer size


// publisher ( e.g trainer )

setTimeout(() => {
    let topicIdx = 0;
    const intervalId = setInterval(() => {
        topicIdx++;
        console.log('new topic published');
        teachStream.next(`topic-${topicIdx}`);
        // if (topicIdx === 3) {
        //     teachStream.error('power failure');
        //     clearInterval(intervalId);
        // }
        if (topicIdx === 5) {
            teachStream.complete();
            clearInterval(intervalId);
        }
    }, 1000);

}, 3000);

// subscriber-1 ( e.g student )

teachStream
    .pipe(filter(topic => topic !== 'topic-3'))
    .subscribe({
        next: (topic) => {
            console.log('student-1 learned', topic);
        },
        complete: () => {
            console.log('student-1 completed learning');
        },
        error: (err) => {
            console.log('student-1 learning error', err);
        }
    })

// subscriber-2

setTimeout(() => {

    teachStream.subscribe({
        next: (topic) => {
            console.log('student-2 learned', topic);
        },
        complete: () => {
            console.log('student-2 completed learning');
        },
        error: (err) => {
            console.log('student-2 learning error', err);
        }
    })

}, 2000);