


//---------------------------------------------
// Trainer
//---------------------------------------------

const trainer = {
    getTopicV1() {
        //
        return 1;
    },
    getTopicV2() {
        const executor = (resolve, reject) => {
            setTimeout(() => {
                console.log("trainer :resolving promise...");
                resolve(1); // success // push data to promise consumer | non-blocking call | async call
                // reject("network issue"); // failure
            }, 5000);
        }
        const promise = new Promise(executor);
        return promise;
    }
}

//---------------------------------------------
// GPT tool
//---------------------------------------------

const gptTool = {
    getMoreDetails(topic) {
        const executor = (resolve, reject) => {
            setTimeout(() => {
                console.log("gptTool :resolving promise...");
                resolve(topic * 10);
                // reject("network issue"); // failure
            }, 4000);
        }
        const promise = new Promise(executor);
        return promise;
    }
}
//---------------------------------------------
// Employee
//---------------------------------------------

const emp = {
    doLearnV1() {
        console.log("employee : learning...");
        console.log("employee : need topic from trainer");
        // const topic = trainer.getTopicV1() // pull topic from trainer | blocking call | sync call
        const promise = trainer.getTopicV2(); // async call
        console.log("employee : got promise, defer action to future")
        promise
            .then(topic => {
                console.log("employee : learning topic - " + topic);
                console.log("employee : need more details from gptTool");
                const promise = gptTool.getMoreDetails(topic)
                promise
                    .then(details => {
                        console.log("employee : learning more details - " + details);
                        console.log("employee : learning completed");
                    })
                    .catch(err => {
                        console.log("employee : details failed with error : " + err);
                    })
            })
            .catch(err => {
                console.log("employee : learning failed with error : " + err);
            })
    },
    async doLearnV2() {
        try {
            const topic = await trainer.getTopicV2();
            const details = await gptTool.getMoreDetails(topic);
            console.log("employee : learning topic - " + topic);
            console.log("employee : learning more details - " + details);
            console.log("employee : learning completed");
        } catch (err) {
            console.log("employee : learning failed with error : " + err);
        }
    },
    doWork() {
        this.doLearnV2();
        console.log("employee : with other work not related to learning");
    }
}

// emp.doWork();

// ---------------------------------------------

// More concepts about promise:

// 1. Promise chaining

// const promise = new Promise((resolve, reject) => {
//     setTimeout(() => {
//         resolve(1);
//     }, 2000);
// });

// promise
//     .then(result => {
//         console.log(result);
//         return result * 2;
//     })
//     .then(result => {
//         console.log(result);
//         return result * 2;
//     })
//     .then(result => {
//         console.log(result);
//         return result * 2;
//     })
//     .then(result => {
//         console.log(result);
//     });

// 2. Promise.all - to wait for multiple promises

const promise1 = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve(1);
    }, 2000);
});

const promise2 = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve(2);
    }, 3000);
});

Promise.all([promise1, promise2])
    .then(results => {
        console.log(results);
    });


// 3. Promise.race - to wait for the fastest promise

const promise3 = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve(3);
    }, 2000);
});


const promise4 = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve(4);
    }, 3000);
});


Promise.race([promise3, promise4])
    .then(result => {
        console.log(result);
    });

// 4. Promise.resolve - to create a promise that is already resolved

const promise5 = Promise.resolve(5);


// 5. Promise.reject - to create a promise that is already rejected

const promise6 = Promise.reject("error");