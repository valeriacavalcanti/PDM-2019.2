//
//  ViewController.swift
//  Tres formas
//
//  Created by Valéria Cavalcanti on 21/11/19.
//  Copyright © 2019 Valéria Cavalcanti. All rights reserved.
//

import UIKit

class MainViewController: UIViewController {

    @IBAction func transicaoForma2(_ sender: Any) {
        let svc = self.storyboard?.instantiateViewController(identifier: "sobre") as! SobreViewController
        self.present(svc, animated: true, completion: nil)
    }
    
}

